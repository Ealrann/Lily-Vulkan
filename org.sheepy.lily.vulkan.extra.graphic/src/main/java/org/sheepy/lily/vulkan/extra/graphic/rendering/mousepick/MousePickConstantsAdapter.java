package org.sheepy.lily.vulkan.extra.graphic.rendering.mousepick;

import org.eclipse.emf.common.notify.Notification;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.ModelExtender;
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
		selectionProxy = constants.getMousePickExtension()
								  .getSelectionProxy();
	}

	@Load
	public void load()
	{
		selectionProxy.listen(selectionListener,
							  RenderingPackage.SELECTION_PROXY__PICK_MODE,
							  RenderingPackage.SELECTION_PROXY__SELECTION);
		stagingBuffer = MemoryUtil.memAlloc(BYTES);
		updateBuffer(selectionProxy.getPickMode());
	}

	@Dispose
	public void dispose()
	{
		selectionProxy.sulk(selectionListener,
							RenderingPackage.SELECTION_PROXY__PICK_MODE,
							RenderingPackage.SELECTION_PROXY__SELECTION);
		MemoryUtil.memFree(stagingBuffer);
	}

	private void onSelectionNotification(Notification notification)
	{
		switch (notification.getFeatureID(MousePickExtension.class))
		{
			case RenderingPackage.SELECTION_PROXY__PICK_MODE -> updateBuffer(selectionProxy.getPickMode());
			case RenderingPackage.SELECTION_PROXY__SELECTION ->
			{
				if (selectionProxy.getPickMode() == EMousePickMode.LOCK)
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
			updateBuffer(selectionProxy.getPickMode());
			wasForcedUpdate = false;
		}
		if (forceUpdate)
		{
			updateBuffer(EMousePickMode.ENABLED);
			wasForcedUpdate = true;
			forceUpdate = false;
		}
	}

	private void updateBuffer(EMousePickMode pickMode)
	{
		stagingBuffer.putInt(pickMode.getValue());
		stagingBuffer.flip();

		constants.setData(stagingBuffer);
	}
}
