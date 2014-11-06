package algorithm;

/**
 * 背包问题(动态规划)
 * @author lujiabin
 * @since 2014-11-6
 */
public class Bag {
	/**
	 * @param value 物品价值数组
	 * @param weight 物品重量数组
	 * @param W 背包容量
	 * @return 所能装的最大价值
	 */
	public static int knapsack(int[] value,int[] weight,int W){
		int N = weight.length;//物品数量
		
		int[][] V = new int[N+1][W+1];//存储每个子背包问题的最大价值
		
		//第0行全置为0 （含义：没有物品时容量为任何值是价值都是0）
		for(int col = 0;col<W+1;col++){
			V[0][col] = 0;
		}
		
		//第0 列全置为0 （含义：背包容量为0时，无论多少件物品，价值都为0）
		for(int row = 0;row<N+1;row++){
			V[row][0] = 0;
		}
		
		//从第一行第一列开始计算
		for(int item = 1;item<N+1;item++){
			for(int wei = 1;wei<W+1;wei++){
				if(weight[item-1]<=wei){
					//第item件物品重量小于等于容量，取第item件物品价值+上一行去掉当前物品重量的最大价值之和与上一行价值之间的较大者
					V[item][wei] = Math.max(value[item-1]+V[item-1][wei-weight[item-1]], V[item-1][wei]);
				}else{
					//第item件物品重量大于容量，用上一行值赋值
					V[item][wei] = V[item-1][wei];
				}
			}
		}
		//打印数组
		for(int[] rows : V){
			for(int col : rows){
				System.out.format("%5d", col);
			}
			System.out.println();
		}
		return V[N][W];
	}
	
	public static void main(String[] args) {
		int[] value = {10,40,30,50};
		int[] weight = {5,4,6,3};
		int W = 10;//背包容量
		
		System.out.println(knapsack(value, weight, W));
	}

}
