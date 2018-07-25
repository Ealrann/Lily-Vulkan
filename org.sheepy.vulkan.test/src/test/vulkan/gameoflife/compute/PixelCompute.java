package test.vulkan.gameoflife.compute;

import java.util.Arrays;

import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.pipeline.compute.ComputePipeline;

public class PixelCompute extends ComputePipeline
{
	private static final String SHADER_LOCATION = "test/vulkan/gameoflife/life2pixel.comp.spv";

	public PixelCompute(LogicalDevice logicalDevice, BoardBuffer board, BoardImage image)
	{
		super(logicalDevice, board.getWidth(), board.getHeight(), 1,
				Arrays.asList(board, image), SHADER_LOCATION);
	}
}
