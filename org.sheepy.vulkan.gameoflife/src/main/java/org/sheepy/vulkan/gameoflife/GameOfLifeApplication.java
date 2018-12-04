package org.sheepy.vulkan.gameoflife;

import org.sheepy.vulkan.api.VulkanApplicationLauncher;
import org.sheepy.vulkan.api.adapter.IProcessPoolAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanApplicationAdapter;
import org.sheepy.vulkan.gameoflife.model.ModelFactory;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.model.process.graphic.GraphicProcessPool;

public class GameOfLifeApplication
{
	private static final int TARGET_FPS = 60;
	private static final int FRAME_TIME_STEP_MS = (int) ((1f / TARGET_FPS) * 1000);

	private long nextRenderDate = 0;
	private int countFrame = 0;
	private long stopCountDate;
	private boolean countFrameEnabled = true;
	private final ModelFactory factory;
	private int currentComputePoolIndex = 0;
	private final IProcessPoolAdapter[] computePoolAdapters = new IProcessPoolAdapter[2];
	private IProcessPoolAdapter renderProcessPoolAdapter;

	public GameOfLifeApplication(int width, int height)
	{
		factory = new ModelFactory(width, height);
	}

	public void launch()
	{
		VulkanApplication application = factory.application;

		var applicationAdapter = VulkanApplicationLauncher.launch(application);
		computePoolAdapters[0] = IProcessPoolAdapter.adapt(factory.computeProcessPool1);
		computePoolAdapters[1] = IProcessPoolAdapter.adapt(factory.computeProcessPool2);
		GraphicProcessPool imageProcessPool = factory.imageProcessPool;
		renderProcessPoolAdapter = IProcessPoolAdapter.adapt(imageProcessPool);

		stopCountDate = System.currentTimeMillis() + 3000;
		nextRenderDate = System.currentTimeMillis() + FRAME_TIME_STEP_MS;

		while (!applicationAdapter.shouldClose())
		{
			step(applicationAdapter);
		}
	}

	private void executeComputePool()
	{
		var currentPoolAdapter = computePoolAdapters[currentComputePoolIndex];
		currentPoolAdapter.execute();
		currentPoolAdapter.getQueue().waitIdle();
		currentComputePoolIndex++;
		if (currentComputePoolIndex > 1)
		{
			currentComputePoolIndex = 0;
		}
	}

	private void step(IVulkanApplicationAdapter adapter)
	{
		adapter.pollEvents();
		adapter.preparePools();

		while (nextRenderDate > System.currentTimeMillis())
		{
			executeComputePool();

			if (countFrameEnabled)
			{
				if (System.currentTimeMillis() > stopCountDate)
				{
					countFrameEnabled = false;
					System.out.println("UPS: " + (int) (countFrame / 3f));
				}
				else
				{
					countFrame++;
				}
			}
		}

		nextRenderDate = System.currentTimeMillis() + FRAME_TIME_STEP_MS;

		renderProcessPoolAdapter.execute();
	}
}
