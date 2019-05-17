package org.sheepy.lily.vulkan.demo.gameoflife.compute;

import org.joml.Vector2i;

public class Board
{
	private final int width;
	private final int height;

	private final boolean[][] values;

	public Board(int width, int height)
	{
		this.width = width;
		this.height = height;

		values = new boolean[width][height];
	}

	public void setValue(int x, int y, boolean value)
	{
		values[x][y] = value;
	}

	public void activate(int x, int y)
	{
		setValue(x, y, true);
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public boolean[][] getValues()
	{
		return values;
	}
	
	public static Board createTestBoard(Vector2i size)
	{
		final Board board = new Board(size.x, size.y);


		// Create a glider
		board.activate(1 + 2, 0);
		board.activate(2 + 2, 1);
		board.activate(0 + 2, 2);
		board.activate(1 + 2, 2);
		board.activate(2 + 2, 2);
		
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
		board.activate(0, 300 + 4);
		board.activate(0, 302 + 4);
		board.activate(3, 300 + 4);
		board.activate(4, 301 + 4);
		board.activate(4, 302 + 4);
		board.activate(4, 303 + 4);
		board.activate(1, 303 + 4);
		board.activate(2, 303 + 4);
		board.activate(3, 303 + 4);

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
