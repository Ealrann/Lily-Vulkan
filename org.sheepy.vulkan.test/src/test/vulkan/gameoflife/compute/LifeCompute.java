package test.vulkan.gameoflife.compute;

import java.util.Arrays;

import org.sheepy.vulkan.pipeline.Context;
import org.sheepy.vulkan.pipeline.compute.ComputePipeline;

public class LifeCompute extends ComputePipeline
{
	private static final String SHADER_LOCATION = "test/vulkan/gameoflife/life.comp.spv";

	public LifeCompute(Context context, BoardBuffer sourceBuffer,
			BoardBuffer targetBuffer)
	{
		super(context, sourceBuffer.getWidth(), sourceBuffer.getHeight(), 1,
				Arrays.asList(sourceBuffer, targetBuffer), SHADER_LOCATION);
	}
}
