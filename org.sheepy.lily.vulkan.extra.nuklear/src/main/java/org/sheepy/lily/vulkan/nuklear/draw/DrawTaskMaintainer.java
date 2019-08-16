package org.sheepy.lily.vulkan.nuklear.draw;

import java.util.List;

import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearContextAdapter;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.surface.Extent2D;

public final class DrawTaskMaintainer
{
	private final CompositeTask drawCompositeTask;
	private final Buffer vertexBuffer;

	public DrawTaskMaintainer(CompositeTask drawCompositeTask, Buffer vertexBuffer)
	{
		this.drawCompositeTask = drawCompositeTask;
		this.vertexBuffer = vertexBuffer;
	}

	public void reloadTasks(final List<DrawCommandData> commands, Extent2D extent)
	{
		drawCompositeTask.getTasks().clear();

		createBindTasks(extent);

		final var context = new Context(extent);
		for (final var command : commands)
		{
			createDrawTasks(context, command);
		}

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			System.out.println("Nuklear draw tasks:");
			for (final var task : drawCompositeTask.getTasks())
			{
				System.out.println(task);
			}
		}
	}

	private void createBindTasks(Extent2D extent)
	{
		final var vertexRef = ResourceFactory.eINSTANCE.createBufferReference();
		vertexRef.setOffset(0);
		vertexRef.setBuffer(vertexBuffer);

		final var indexRef = ResourceFactory.eINSTANCE.createBufferReference();
		indexRef.setOffset(NuklearContextAdapter.INDEX_OFFSET);
		indexRef.setBuffer(vertexBuffer);

		final var vertexBinding = GraphicFactory.eINSTANCE.createVertexBinding();
		vertexBinding.setBufferRef(vertexRef);

		final var bindVertexBuffer = GraphicFactory.eINSTANCE.createBindVertexBuffer();
		bindVertexBuffer.getVertexBindings().add(vertexBinding);

		final var bindIndexBuffer = GraphicFactory.eINSTANCE.createBindIndexBuffer();
		bindIndexBuffer.setBufferRef(indexRef);
		bindIndexBuffer.setIndexType(EIndexType.UINT16);

		final var setViewport = GraphicFactory.eINSTANCE.createSetViewport();
		setViewport.setWidth(extent.getWidth());
		setViewport.setHeight(extent.getHeight());

		drawCompositeTask.getTasks().add(bindVertexBuffer);
		drawCompositeTask.getTasks().add(bindIndexBuffer);
		drawCompositeTask.getTasks().add(setViewport);
	}

	private void createDrawTasks(Context context, DrawCommandData commandData)
	{
		updateDescriptor(context, commandData);
		updateScissor(context, commandData);
		drawIndexed(context, commandData);
	}

	private void updateDescriptor(Context context, DrawCommandData commandData)
	{
		final int currentIndex = commandData.descriptorIndex;
		if (context.previousDescriptorSet != currentIndex)
		{
			final var pushConstant = NuklearFactory.eINSTANCE.createNuklearPushConstants();
			pushConstant.setCurrentDescriptor(currentIndex);
			pushConstant.setWidth(context.extent.getWidth());
			pushConstant.setHeight(context.extent.getHeight());
			pushConstant.getStages().add(EShaderStage.VERTEX_BIT);
			pushConstant.getStages().add(EShaderStage.FRAGMENT_BIT);

			drawCompositeTask.getTasks().add(pushConstant);

			context.previousDescriptorSet = currentIndex;
		}
	}

	private void updateScissor(Context context, DrawCommandData commandData)
	{
		final int x = Math.max(commandData.xOffset, 0);
		final int y = Math.max(commandData.yOffset, 0);
		final int w = Math.min(commandData.xExtent, context.extent.getWidth());
		final int h = Math.min(commandData.yExtent, context.extent.getHeight());

		if (x != context.lastScissorX
				|| y != context.lastScissorY
				|| w != context.lastScissorW
				|| h != context.lastScissorH)
		{
			final var setScissor = GraphicFactory.eINSTANCE.createSetScissor();
			setScissor.setOffsetX(x);
			setScissor.setOffsetY(y);
			setScissor.setWidth(w);
			setScissor.setHeight(h);

			drawCompositeTask.getTasks().add(setScissor);

			context.lastScissorX = x;
			context.lastScissorY = y;
			context.lastScissorW = w;
			context.lastScissorH = h;
		}
	}

	private void drawIndexed(Context context, DrawCommandData commandData)
	{
		final var drawIndexed = GraphicFactory.eINSTANCE.createDrawIndexed();
		drawIndexed.setIndexCount(commandData.elemCount);
		drawIndexed.setFirstIndex(context.indexOffset);

		drawCompositeTask.getTasks().add(drawIndexed);

		context.indexOffset += commandData.elemCount;
	}

	private static final class Context
	{
		public final Extent2D extent;

		public int previousDescriptorSet = -1;
		public int indexOffset = 0;
		public float lastScissorX = -1;
		public float lastScissorY = -1;
		public float lastScissorW = -1;
		public float lastScissorH = -1;

		public Context(Extent2D extent)
		{
			this.extent = extent;
		}
	}
}
