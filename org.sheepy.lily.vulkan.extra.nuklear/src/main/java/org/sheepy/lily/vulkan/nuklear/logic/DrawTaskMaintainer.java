package org.sheepy.lily.vulkan.nuklear.logic;

import org.joml.Vector2ic;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import java.util.List;

public final class DrawTaskMaintainer
{
	private final CompositeTask drawCompositeTask;
	private final BufferMemory vertexBuffer;

	public DrawTaskMaintainer(CompositeTask drawCompositeTask, BufferMemory vertexBuffer)
	{
		this.drawCompositeTask = drawCompositeTask;
		this.vertexBuffer = vertexBuffer;
	}

	public void reloadTasks(final List<DrawCommandData> commands, Vector2ic extent)
	{
		drawCompositeTask.tasks().clear();

		createBindTasks(extent);

		final var context = new Context(extent);
		for (final var command : commands)
		{
			createDrawTasks(context, command);
		}

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			printTaskTree();
		}
	}

	private void createBindTasks(Vector2ic extent)
	{
		final var vertexBinding = VertexBinding.builder().build();
		vertexBinding.buffer(vertexBuffer.buffers().get(0));

		final var bindVertexBuffer = BindVertexBuffer.builder().build();
		bindVertexBuffer.vertexBindings().add(vertexBinding);

		final var bindIndexBuffer = BindIndexBuffer.builder().build();
		bindIndexBuffer.buffer(vertexBuffer.buffers().get(1));
		bindIndexBuffer.indexType(EIndexType.UINT16);

		final var setViewport = SetViewport.builder().build();
		setViewport.width(extent.x());
		setViewport.height(extent.y());

		drawCompositeTask.tasks().add(bindVertexBuffer);
		drawCompositeTask.tasks().add(bindIndexBuffer);
		drawCompositeTask.tasks().add(setViewport);
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
			final var pushConstant = NuklearPushConstants.builder().build();
			pushConstant.currentDescriptor(currentIndex);
			pushConstant.width(context.extent.x());
			pushConstant.height(context.extent.y());
			pushConstant.stages().add(EShaderStage.VERTEX_BIT);
			pushConstant.stages().add(EShaderStage.FRAGMENT_BIT);

			drawCompositeTask.tasks().add(pushConstant);

			context.previousDescriptorSet = currentIndex;
		}
	}

	private void updateScissor(Context context, DrawCommandData commandData)
	{
		final int x = Math.max(commandData.xOffset, 0);
		final int y = Math.max(commandData.yOffset, 0);
		final int w = Math.min(commandData.xExtent, context.extent.x());
		final int h = Math.min(commandData.yExtent, context.extent.y());

		if (x != context.lastScissorX || y != context.lastScissorY || w != context.lastScissorW || h != context.lastScissorH)
		{
			final var setScissor = SetScissor.builder().build();
			setScissor.offsetX(x);
			setScissor.offsetY(y);
			setScissor.width(w);
			setScissor.height(h);

			drawCompositeTask.tasks().add(setScissor);

			context.lastScissorX = x;
			context.lastScissorY = y;
			context.lastScissorW = w;
			context.lastScissorH = h;
		}
	}

	private void drawIndexed(Context context, DrawCommandData commandData)
	{
		final var drawIndexed = DrawIndexed.builder().build();
		drawIndexed.indexCount(commandData.elemCount);
		drawIndexed.firstIndex(context.indexOffset);

		drawCompositeTask.tasks().add(drawIndexed);

		context.indexOffset += commandData.elemCount;
	}

	private void printTaskTree()
	{
		System.out.println("Nuklear draw tasks:");
		for (final var task : drawCompositeTask.tasks())
		{
			System.out.println(task);
		}
	}

	private static final class Context
	{
		public final Vector2ic extent;

		public int previousDescriptorSet = -1;
		public int indexOffset = 0;
		public float lastScissorX = -1;
		public float lastScissorY = -1;
		public float lastScissorW = -1;
		public float lastScissorH = -1;

		public Context(Vector2ic extent)
		{
			this.extent = extent;
		}
	}
}
