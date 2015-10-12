import java.util.Scanner;

public class BuildingWaterBlock {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter no. of buildings");

		int N = in.nextInt();
		int[] buildings = new int[N];
		for (int i = 0; i < N; i++) {
			buildings[i] = in.nextInt();
		}

		System.out.println(calcWaterStored(buildings));
	}

	static int calcWaterStored(int[] buildingBlocks) {
		int res = 0;
		int n = buildingBlocks.length;
		int begin = 0;
		int end = n - 1;
		int waterSize = 0;
		for (int i = 0; i < n-1;) {
			if (buildingBlocks[i] <= buildingBlocks[i + 1]) {
				i++;
			} else {
				begin = i;
				break;
			}
		}
		for (int i = n-1; i > 0;) {
			if (buildingBlocks[i] <= buildingBlocks[i - 1]) {
				i--;
			} else {
				end = i;
				break;
			}
		}
		int count = 0;
		
		if (begin < end) {
			for (int i = begin + 1; i <= end;) {
				
				if (buildingBlocks[i] >= buildingBlocks[begin]) {
					res += waterSize;
					waterSize = 0;
					begin = i;
					count = 0;
					while (i <= end
							&& buildingBlocks[i] >= buildingBlocks[begin])
						i++;
				} else {
					waterSize += buildingBlocks[begin] - buildingBlocks[i];
					i++;
					count++;
				}
			}
			if (buildingBlocks[end] < buildingBlocks[begin]) {
				res += waterSize
						- (count * (buildingBlocks[begin] - buildingBlocks[end]));
			}
		}
		return res;

	}
}
