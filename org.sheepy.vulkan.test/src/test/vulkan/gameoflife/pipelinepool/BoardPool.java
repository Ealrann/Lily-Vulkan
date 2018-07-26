package test.vulkan.gameoflife.pipelinepool;

import static org.lwjgl.vulkan.VK10.VK_FORMAT_R8G8B8A8_UNORM;

import org.sheepy.vulkan.buffer.Image;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.compute.ComputeProcess;
import org.sheepy.vulkan.pipeline.compute.ComputeProcessPool;

import test.vulkan.gameoflife.Board;
import test.vulkan.gameoflife.compute.BoardBuffer;
import test.vulkan.gameoflife.compute.BoardImage;
import test.vulkan.gameoflife.compute.LifeCompute;
import test.vulkan.gameoflife.compute.PixelCompute;

public class BoardPool extends ComputeProcessPool
{
	private Board board;
	private BoardImage image;

	public BoardPool(LogicalDevice logicalDevice, Board board)
	{
		super(logicalDevice, false);
		this.board = board;

		buildPipelines();
	}

	public void buildPipelines()
	{
		BoardBuffer boardBuffer1 = new BoardBuffer(logicalDevice, board,
				logicalDevice.getQueueManager().getComputeQueue());
		BoardBuffer boardBuffer2 = new BoardBuffer(logicalDevice, board,
				logicalDevice.getQueueManager().getComputeQueue());

		addResource(boardBuffer1);
		addResource(boardBuffer2);

		image = new BoardImage(logicalDevice, logicalDevice.getQueueManager().getComputeQueue(),
				board.getWidth(), board.getHeight(), VK_FORMAT_R8G8B8A8_UNORM);

		addResource(image);

		ComputeProcess boardProcess1 = new ComputeProcess(context);
		ComputeProcess boardProcess2 = new ComputeProcess(context);

		LifeCompute lifeComputer1 = new LifeCompute(context, boardBuffer2, boardBuffer1);
		LifeCompute lifeComputer2 = new LifeCompute(context, boardBuffer1, boardBuffer2);

		PixelCompute pixelComputer1 = new PixelCompute(context, boardBuffer1, image);
		PixelCompute pixelComputer2 = new PixelCompute(context, boardBuffer2, image);

		boardProcess1.addProcessUnit(lifeComputer1);
		boardProcess1.addProcessUnit(pixelComputer1);

		boardProcess2.addProcessUnit(lifeComputer2);
		boardProcess2.addProcessUnit(pixelComputer2);

		addProcess(boardProcess1);
		addProcess(boardProcess2);
	}

	public Image getImage()
	{
		return image.getImage();
	}
}
