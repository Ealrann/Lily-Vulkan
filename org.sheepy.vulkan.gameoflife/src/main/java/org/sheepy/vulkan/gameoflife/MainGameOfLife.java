package org.sheepy.vulkan.gameoflife;

public class MainGameOfLife
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static void main(String[] args)
	{
		GameOfLifeApplication app = new GameOfLifeApplication(WIDTH, HEIGHT);

		try
		{
			app.launch();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
