package org.sheepy.vulkan.gameoflife;

import org.sheepy.common.api.application.ApplicationLauncher;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.vulkan.api.window.IWindow;
import org.sheepy.vulkan.gameoflife.model.ModelFactory;
import org.sheepy.vulkan.model.process.graphic.GraphicProcess;

public class GameOfLifeApplication
{
	private static final int TARGET_FPS = 60;
	private static final int FRAME_TIME_STEP_MS = (int) ((1f / TARGET_FPS) * 1000);

	private long nextRenderDate = 0;
	private int countFrame = 0;
	private long stopCountDate;
	private boolean countFrameEnabled = true;
	private final ModelFactory factory;
	private final IProcessAdapter[] computeProcessAdapters = new IProcessAdapter[2];
	private IProcessAdapter imageProcessAdapter;
	private int currentComputePoolIndex = 0;

	public GameOfLifeApplication(int width, int height)
	{
		factory = new ModelFactory(width, height);
	}

	public void launch()
	{
		Application application = factory.application;
		ApplicationLauncher.launch(application);

		var engineAdapter = IVulkanEngineAdapter.adapt(factory.engine);
		computeProcessAdapters[0] = IProcessAdapter.adapt(factory.computeProcess1);
		computeProcessAdapters[1] = IProcessAdapter.adapt(factory.computeProcess2);
		GraphicProcess imageProcess = factory.imageProcess;
		imageProcessAdapter = IProcessAdapter.adapt(imageProcess);

		stopCountDate = System.currentTimeMillis() + 3000;
		nextRenderDate = System.currentTimeMillis() + FRAME_TIME_STEP_MS;

		engineAdapter.allocate();

		IWindow window = engineAdapter.getWindow();
		while (!window.shouldClose())
		{
			step(engineAdapter);
		}

		engineAdapter.free();
	}

	private void executeComputePool()
	{
		var currentPoolAdapter = computeProcessAdapters[currentComputePoolIndex];
		currentPoolAdapter.execute();
		currentPoolAdapter.getQueue().waitIdle();
		currentComputePoolIndex++;
		if (currentComputePoolIndex > 1)
		{
			currentComputePoolIndex = 0;
		}
	}

	private void step(IVulkanEngineAdapter adapter)
	{
		adapter.pollEvents();
		computeProcessAdapters[0].prepare();
		computeProcessAdapters[1].prepare();

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

		imageProcessAdapter.prepare();
		imageProcessAdapter.execute();
	}
}
