package com.daleyzou.algorithm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 朴素贝叶斯分类器的java实现
 * @auther: DaleyZou
 * @date: 23:32 2018/10/24
 */
public class NBClassifier {
	public static void train(String trainingData, String modelFile) throws Exception {
		if ((new File(modelFile)).exists()) {
			return;
		} else {
			/***********************************************************/
			/*
			 * 在else中添加由MapReduce实现的模型训练的代码。
			 * 注意：
			 *     在模型训练完成之后，需要将在Hadoop上训练得到的模型文件数据（一般其名称
			 *     为"part-r-00000"）下载到指定的本地目录下，该目录与modelFile相同，
			 *     名称与modelFile相同
			 */
			
			/***********************************************************/
		}
	}
	
	public static HashMap<String, Integer> prior = null;
	public static double priorNorm = 0.;//文件中的总记录数
	public static HashMap<String, Integer> likelihood = null;
	public static HashMap<String, Double> likelihoodNorm = null;
	public static HashSet<String> V = null;
	
	
	/**
	 * 对应MapReduce中的第二步，准备第三步需要的参数
	 */
	public static void loadModel(String modelFile) throws Exception {
		if (prior != null && likelihood != null) {
			return;
		}
		/**
		 喜悦-你好	123
		 喜悦	630
		 */
		
		prior = new HashMap<String, Integer>();//喜悦	630 
		likelihood = new HashMap<String, Integer>();//喜悦-你好	123	 //将文件以键值对方式存储，\t作为分割读取
		likelihoodNorm = new HashMap<String, Double>();//某一类别下所有词出现的总数
		V = new HashSet<String>();//文件的全部词汇表集合
		
		BufferedReader br = new BufferedReader(new FileReader(modelFile));
		String line = null;
		
		while ((line = br.readLine()) != null) {
			String feature = line.substring(0, line.indexOf("\t"));
			Integer count = Integer.parseInt(line.substring(line.indexOf("\t") + 1));
			
			if (feature.contains("-")) {
				likelihood.put(feature, count);
				
				String label = feature.substring(0, feature.indexOf("-"));
				
				if (likelihoodNorm.containsKey(label)) {
					likelihoodNorm.put(label, likelihoodNorm.get(label) + count);
				} else {
					likelihoodNorm.put(label, (double)count);
				}
				
				String word = feature.substring(feature.indexOf("-") + 1);
				
				if (!V.contains(word)) {
					V.add(word);
				}
			} else {
				prior.put(feature, count);
				priorNorm += count;
			}
		}
		
		br.close();
	}
	
	
	/**
	 * 对应MapReduce中的第三步，计算出每个类别中得条件概率
	 * 	我的观点：或许这一步不需要独立出来，他只是map之前的一个初始化的步骤而已。明天继续探讨
	 */
	public static String predict(String sentence, String modelFile) throws Exception {
		loadModel(modelFile);
		
		String predLabel = null;
		double maxValue = Double.NEGATIVE_INFINITY;//最大类概率（默认值为负无穷小）,是否可以写成0？（无穷小本身就是接近0）
		
		String[] words = sentence.split(" ");
		Set<String> labelSet = prior.keySet();
		
		for (String label : labelSet) {
			double tempValue = Math.log(prior.get(label) / priorNorm);//先验概率
			//prior.get(label):类别c对应的文档在训练数据集中的计数
			//priorNorm:训练数据集中包含的文档总数
			
			for (String word : words) {
				if (!V.contains(word)) {
					continue;
				}
				String pseudoW = label + "-" + word;
				//计算最大似然概率
				if (likelihood.containsKey(pseudoW)) {
					tempValue += Math.log((likelihood.get(pseudoW) + 1) / (likelihoodNorm.get(label) + V.size()));
					/**
					 * likelihood.get(pseudoW)：类别c与词语 w共同出现的次数
					 * likelihoodNorm.get(label) + V.size()：类别c与所有词语 共同出现的次数
					 * 											+该文件中distinct(该文件中词语种类)
					 */
				} else {
					tempValue += Math.log(1 / (likelihoodNorm.get(label) + V.size()));
				}
			}
			
			if (tempValue > maxValue) {
				maxValue = tempValue;
				predLabel = label;
			}
		}
		
		return predLabel;
	}
	
	/**
	 * 对应到MapReduce中的第三步，一条一条的读进来后进行判断
	 */
	public static void validate(String sentencesFile, String modelFile, String resultFile) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(sentencesFile));
		String sentence = null;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile));
		
		while ((sentence = br.readLine()) != null) {
			String predLabel = predict(sentence, modelFile);
			
			bw.append(predLabel + "\r\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws Exception {
		//String trainingFile = ""; // 这里指定hdfs下training data的scheme
		String modelFile = "part-r-00000"; // 这里指定model文件将放置在本地的那个目录下，并给model文件命名
		//NBClassifier.train(trainingFile, modelFile);
		
		if ((new File(modelFile)).exists()) {
			String sentencesFile = "C:/Users/11543/Desktop/Hadoop/hadoop/sentences.txt"; // 这里指定sentences.txt文件的路径
			String resultFile = "C:/Users/11543/Desktop/Hadoop/Hadoop要交/20150811_23_预测结果.txt"; // 这里指定结果文件路径，结果文件的名称按照指定要求描述
			NBClassifier.validate(sentencesFile, modelFile, resultFile);
		}
	}
}
