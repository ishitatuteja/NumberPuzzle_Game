import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}

	public int getHeight() {
		return 250;
	}

	public int getXPosition() {
		return 200;
	}

	public int getYPosition() {
		return 200;
	}

	public String getTitle() {
		return "Number Puzzle";
	}

	public int getShuffleButtonFontSize() {
		return 12;
	}

	public int getNumbersFontSize() {
		return 12;
	}

	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}

	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game) {
		int emptyCellId = game.getEmptyCellId();
		System.out.println(emptyCellId);
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();

		// Your logic here
		boolean isValid = false;
		if(emptyCellId+1<=buttons.length-1) {
			if(buttons[emptyCellId+1].equals(buttonClicked))
				isValid = true;
		}
		if(emptyCellId+4<=(buttons.length-1)) {
			if(buttons[emptyCellId+4].equals(buttonClicked))
				isValid = true;
		}
		if(emptyCellId>=1) {
			if(buttons[emptyCellId-1].equals(buttonClicked))
				isValid = true;
		}
		if(emptyCellId>=4) {
			if(buttons[emptyCellId-4].equals(buttonClicked))
				isValid = true;
		}
		 
		if(isValid) {
			swapButton(buttons[emptyCellId],buttonClicked);
			for(int i=0; i<buttons.length;i++) {
				if(buttons[i].equals(buttonClicked)) {
					emptyCellId=i;
					break;
				}
			}
		}

		return emptyCellId;
		

	}

	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		boolean unique[] = new boolean[16];
		// Your logic here
		for (int i = 0; i < 15; i++) {
			int x = (getRandomNumber() % 15) + 1;
			while (unique[x] == true) {
				x = (getRandomNumber() % 15) + 1;
			}
			unique[x] = true;
			arr[i] = x;
		}

		return arr;
	}

	public boolean checkForWinner(Button[] buttons) {
		boolean winner = true;

		// Your Logic here
		int[] buttonIds = getIntegerArrayOfButtonIds(buttons);

		for(int i=1;i<15;i++)
			if(i!=buttonIds[i])
				winner=false;

		return winner;
	
	}
}