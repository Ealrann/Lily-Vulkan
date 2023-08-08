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
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

@ModelExtender(scope = MousePickConstants.class)
@Adapter
@AutoLoad
public class MousePickConstantsAdapter implements IAdapter
{
	private static final int BYTES = 4;

	private final MousePickConstants constants;
	private final Consumer<Notification> pickModeListener = this::playerNotification;
	private final MousePickExtension mousePickExtension;

	private ByteBuffer stagingBuffer;
	private boolean forceUpdate = false;
	private boolean wasForcedUpdate = false;

	public MousePickConstantsAdapter(final MousePickConstants constants)
	{
		this.constants = constants;
		mousePickExtension = constants.getMousePickExtension();
	}

	@Load
	public void load()
	{
		mousePickExtension.listen(pickModeListener,
								  RenderingPackage.MOUSE_PICK_EXTENSION__PICK_MODE,
								  RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION);
		stagingBuffer = MemoryUtil.memAlloc(BYTES);
		updateBuffer(mousePickExtension.getPickMode());
	}

	@Dispose
	public void dispose()
	{
		mousePickExtension.sulk(pickModeListener,
								RenderingPackage.MOUSE_PICK_EXTENSION__PICK_MODE,
								RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION);
		MemoryUtil.memFree(stagingBuffer);
	}

	private void playerNotification(Notification notification)
	{
		switch (notification.getFeatureID(MousePickExtension.class))
		{
			case RenderingPackage.MOUSE_PICK_EXTENSION__PICK_MODE -> updateBuffer(mousePickExtension.getPickMode());
			case RenderingPackage.MOUSE_PICK_EXTENSION__SELECTION ->
			{
				if (mousePickExtension.getPickMode() == EMousePickMode.LOCK)
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
			updateBuffer(mousePickExtension.getPickMode());
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
