package org.sheepy.lily.vulkan.gameoflife;

import org.sheepy.lily.core.api.cadence.IMainLoop;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.adapter.IProcessAdapter;
import org.sheepy.lily.vulkan.gameoflife.model.ModelFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;

public class MainLoop implements IMainLoop
{
	private static final int TARGET_FPS = 60;
	private static final int FRAME_TIME_STEP_MS = (int) ((1f / TARGET_FPS) * 1000);

	public final ModelFactory factory;

	private long nextRenderDate = 0;
	private int countFrame = 0;
	private long stopCountDate;
	private boolean countFrameEnabled = true;
	private final IProcessAdapter[] computeProcessAdapters = new IProcessAdapter[2];
	private IProcessAdapter imageProcessAdapter;
	private int currentComputePoolIndex = 0;

	public MainLoop(ModelFactory factory)
	{
		this.factory = factory;
	}

	@Override
	public void load(Application application)
	{
		computeProcessAdapters[0] = IProcessAdapter.adapt(factory.process1);
		computeProcessAdapters[1] = IProcessAdapter.adapt(factory.process2);
		GraphicProcess imageProcess = factory.imageProcess;
		imageProcessAdapter = IProcessAdapter.adapt(imageProcess);

		stopCountDate = System.currentTimeMillis() + 3000;
		nextRenderDate = System.currentTimeMillis() + FRAME_TIME_STEP_MS;

		factory.engine.setEnabled(true);
	}

	@Override
	public void step(Application application)
	{
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

	@Override
	public void free(Application application)
	{}

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
}
