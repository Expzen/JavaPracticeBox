
public class Aladdin {

	public static void main(String[] args) {
		// 玩家為O，對手為X，O可以藉由跳過X移動並吃掉X
		// O可以朝八個方向移動，X不會移動
		// 這個程式求O可以移動多少步
		Aladdin aladdin = new Aladdin();
		// 棋盤地圖，其中.為空位
		int r = aladdin.startGame(new String[] {
				"X..X.",
				".X.XX",
				"..O..",
				"X.X..",
				"X.X..",});
		// 輸出結果
		System.out.println(r);
	}
	
	public int startGame(String[] B) {
		// find start point
		Pos initpos = new Pos();
		char[][] map = new char[B.length][];
		for (int i = 0; i < B.length; i++) {
			map[i] = new char[B[i].length()];
			for (int j = 0; j < B[i].length(); j++) {
				map[i][j] = B[i].charAt(j);
				if (map[i][j] == 'O') {
					initpos.y = i;
					initpos.x = j;
				}
			}
		}
		// start
		run(map, initpos, 0);
		return index - 1;
	}

	int index = 0;

	private void hit(int depth) {
		if (depth > index)
			index = depth;
	}

	private void run(char[][] board, Pos pos, int depth) {
		depth += 1;
		if (pos.y + 2 < board.length) {
			// s
			if (board[pos.y + 1][pos.x] == 'X'
					&& board[pos.y + 2][pos.x] == '.') {
				char[][] a = board.clone();
				a[pos.y][pos.x] = '.';
				a[pos.y + 1][pos.x] = '.';
				a[pos.y + 2][pos.x] = 'O';
				run(a, new Pos(pos.x, pos.y + 2), depth);
			}

			// nw
			if (pos.x + 2 < board[0].length) {
				// w
				if (board[pos.y + 1][pos.x + 1] == 'X'
						&& board[pos.y + 2][pos.x + 2] == '.') {
					char[][] a = board.clone();
					a[pos.y][pos.x] = '.';
					a[pos.y + 1][pos.x + 1] = '.';
					a[pos.y + 2][pos.x + 2] = 'O';
					run(a, new Pos(pos.x + 2, pos.y + 2), depth);
				}
			}
			// ne
			if (pos.x - 2 >= 0) {
				// e
				if (board[pos.y + 1][pos.x - 1] == 'X'
						&& board[pos.y + 2][pos.x - 2] == '.') {
					char[][] a = board.clone();
					a[pos.y][pos.x] = '.';
					a[pos.y + 1][pos.x - 1] = '.';
					a[pos.y + 2][pos.x - 2] = 'O';
					run(a, new Pos(pos.x - 2, pos.y + 2), depth);
				}
			}
		}

		if (pos.y - 2 >= 0) {
			// n
			if (board[pos.y - 1][pos.x] == 'X'
					&& board[pos.y - 2][pos.x] == '.') {
				char[][] a = board.clone();
				a[pos.y][pos.x] = '.';
				a[pos.y - 1][pos.x] = '.';
				a[pos.y - 2][pos.x] = 'O';
				run(a, new Pos(pos.x, pos.y - 2), depth);
			}

			// nw
			if (pos.x + 2 < board[0].length) {
				// w
				if (board[pos.y - 1][pos.x + 1] == 'X'
						&& board[pos.y - 2][pos.x + 2] == '.') {
					char[][] a = board.clone();
					a[pos.y][pos.x] = '.';
					a[pos.y - 1][pos.x + 1] = '.';
					a[pos.y - 2][pos.x + 2] = 'O';
					run(a, new Pos(pos.x + 2, pos.y - 2), depth);
				}
			}
			// ne
			if (pos.x - 2 >= 0) {
				// e
				if (board[pos.y - 1][pos.x - 1] == 'X'
						&& board[pos.y - 2][pos.x - 2] == '.') {
					char[][] a = board.clone();
					a[pos.y][pos.x] = '.';
					a[pos.y - 1][pos.x - 1] = '.';
					a[pos.y - 2][pos.x - 2] = 'O';
					run(a, new Pos(pos.x - 2, pos.y - 2), depth);
				}
			}
		}

		if (pos.x + 2 < board[0].length) {
			// w
			if (board[pos.y][pos.x + 1] == 'X'
					&& board[pos.y][pos.x + 2] == '.') {
				char[][] a = board.clone();
				a[pos.y][pos.x] = '.';
				a[pos.y][pos.x + 1] = '.';
				a[pos.y][pos.x + 2] = 'O';
				run(a, new Pos(pos.x + 2, pos.y), depth);
			}
		}

		if (pos.x - 2 >= 0) {
			// e
			if (board[pos.y][pos.x - 1] == 'X'
					&& board[pos.y][pos.x - 2] == '.') {
				char[][] a = board.clone();
				a[pos.y][pos.x] = '.';
				a[pos.y][pos.x - 1] = '.';
				a[pos.y][pos.x - 2] = 'O';
				run(a, new Pos(pos.x - 2, pos.y), depth);
			}
		}
		hit(depth);
	}

	class Pos {
		public int x;
		public int y;

		public Pos() {
			x = 0;
			y = 0;
		}

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

}
