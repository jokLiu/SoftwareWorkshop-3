import java.util.Scanner;

public class BlackBoxDomineering2 {

	private static class CommandLineBlackBox implements MoveChannel<DomineeringMove> {

		public DomineeringMove getMove() {
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();

			int one = 0, two;
			String str = "";
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != ',') {
					str += s.charAt(i);
				} else {
					one = Integer.parseInt(str);
					str = "";
				}
			}

			two = Integer.parseInt(str);
			System.out.println(one + " " + two);
			return (new DomineeringMove(one, two));
		}

		public void giveMove(DomineeringMove move) {
			System.err.println("I play " + move);
			System.out.println(move);
		}

		public void comment(String msg) {
			System.out.println(msg);
		}

		public void end(int value) {
			System.out.println("Game over. The result is " + value);
		}
	}

	public static void main(String[] args) {
		assert (args.length == 4);
		String whoStarts = args[0];
		int width = Integer.parseInt(args[2]);
		int height = Integer.parseInt(args[3]);
		Board2<DomineeringMove> board = new DomBoard(width, height);
		if (height * width > 25) {
			if (whoStarts.equals("first")) {
				board.tree().firstPlayer(new CommandLineBlackBox(), false);
			} else if(whoStarts.equals("second")) {
				board.tree().secondPlayer(new CommandLineBlackBox(), false);
			}
			else System.exit(1);
		} else {
			if (whoStarts.equals("first")) {
				board.tree().firstPlayer(new CommandLineBlackBox(), true);
			} else if(whoStarts.equals("second")) {
				board.tree().secondPlayer(new CommandLineBlackBox(), true);
			}
			else System.exit(1);
		}

	}

}
