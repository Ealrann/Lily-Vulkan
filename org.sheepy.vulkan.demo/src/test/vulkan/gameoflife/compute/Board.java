package test.vulkan.gameoflife.compute;

public class Board
{
	private final int width;
	private final int height;

	private final int size;

	private final boolean[] values;

	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;

		size = width * height;

		values = new boolean[size];
	}

	public void setValue(int x, int y, boolean value)
	{
		values[y * width + x] = value;
	}

	public void activate(int x, int y)
	{
		setValue(x, y, true);
	}
	
	public boolean isActivated(int arrayLocation)
	{
		return values[arrayLocation];
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public boolean[] getValues()
	{
		return values;
	}
	
	public static Board createTestBoard(int width, int height)
	{
		Board board = new Board(width, height);

		// Create little spaceshift
		board.activate(0, 200);
		board.activate(0, 202);
		board.activate(3, 200);
		board.activate(4, 201);
		board.activate(4, 202);
		board.activate(4, 203);
		board.activate(1, 203);
		board.activate(2, 203);
		board.activate(3, 203);

		// Create little spaceshift
		board.activate(0, 300);
		board.activate(0, 302);
		board.activate(3, 300);
		board.activate(4, 301);
		board.activate(4, 302);
		board.activate(4, 303);
		board.activate(1, 303);
		board.activate(2, 303);
		board.activate(3, 303);

		// Create little spaceshift
		board.activate(0, 400);
		board.activate(0, 402);
		board.activate(3, 400);
		board.activate(4, 401);
		board.activate(4, 402);
		board.activate(4, 403);
		board.activate(1, 403);
		board.activate(2, 403);
		board.activate(3, 403);

		return board;
	}
}
