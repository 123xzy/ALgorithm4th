package net.xzy;
/**
 * 随机数静态方法库的API：
 * void setSeed(long seed):设置随机生成器的种子
 * double random():0-1之间的实数
 * 
 * int uniform(int N):0-N-1之间的整数
 * int uniform(int lo,int hi):lo-hi之间的整数
 * double uniform(double lo,double hi):lo-hi之间的实数
 * 
 * boolean bernoulli(double p):返回真的概率
 * double gaussian():正态分布，期望值为1，标准差为1
 * double gaussian(double m,double s):正态分布，期望值为m，标准差为s
 * int disctrte(double[] a):返回i的概率为a[i]
 * void shuffle(double[] a):将数组a随机排序
 * @author xzy
 *
 */
public class StdRandom {

}
