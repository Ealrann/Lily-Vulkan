package org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.IAdapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notification;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.vulkan.extra.model.rendering.*;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

@ModelExtender(scope = MousePickConstants.class)
@Adapter
@AutoLoad
public class MousePickConstantsAdapter implements IAdapter
{
	private static final int BYTES = 4;

	private final MousePickConstants constants;
	private final Consumer<Notification> selectionListener = this::onSelectionNotification;
	private final SelectionProxy selectionProxy;

	private ByteBuffer stagingBuffer;
	private boolean forceUpdate = false;
	private boolean wasForcedUpdate = false;

	public MousePickConstantsAdapter(final MousePickConstants constants)
	{
		this.constants = constants;
		selectionProxy = constants.mousePickExtension()
								  .selectionProxy();
	}

	@Load
	public void load()
	{
		selectionProxy.notifier().listen(selectionListener,
										 SelectionProxy.FeatureIDs.PICK_MODE,
										 SelectionProxy.FeatureIDs.SELECTION);
		stagingBuffer = MemoryUtil.memAlloc(BYTES);
		updateBuffer(selectionProxy.pickMode());
	}

	@Dispose
	public void dispose()
	{
		selectionProxy.notifier().sulk(selectionListener,
									   SelectionProxy.FeatureIDs.PICK_MODE,
									   SelectionProxy.FeatureIDs.SELECTION);
		MemoryUtil.memFree(stagingBuffer);
	}

	private void onSelectionNotification(Notification notification)
	{
		switch (notification.featureId())
		{
			case SelectionProxy.FeatureIDs.PICK_MODE -> updateBuffer(selectionProxy.pickMode());
			case SelectionProxy.FeatureIDs.SELECTION ->
			{
				if (selectionProxy.pickMode() == EMousePickMode.Lock)
				{
					forceUpdate = true;
				}
			}
		}
	}

	@Tick
	public void tick()
	{
		if (wasForcedUpdate)
		{
			updateBuffer(selectionProxy.pickMode());
			wasForcedUpdate = false;
		}
		if (forceUpdate)
		{
			updateBuffer(EMousePickMode.Enabled);
			wasForcedUpdate = true;
			forceUpdate = false;
		}
	}

	private void updateBuffer(EMousePickMode pickMode)
	{
		stagingBuffer.putInt(pickMode.value());
		stagingBuffer.flip();

		constants.data(stagingBuffer);
	}
}
