package org.sheepy.lily.vulkan.nuklear.builder;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearFactory;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPipelineBuilder;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.nuklear.builder.internal.ColorBlendFactory;
import org.sheepy.lily.vulkan.nuklear.builder.internal.DynamicStateFactory;
import org.sheepy.lily.vulkan.nuklear.builder.internal.PushContantsBuilder;
import org.sheepy.lily.vulkan.nuklear.builder.internal.ResourceBuilder;
import org.sheepy.lily.vulkan.nuklear.builder.internal.ShaderBuilder;
import org.sheepy.lily.vulkan.nuklear.builder.internal.VertexDescriptorBuilder;
import org.sheepy.lily.vulkan.nuklear.builder.internal.ViewportStateFactory;
import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelineFactory;

@Statefull
@Adapter(scope = NuklearPipelineBuilder.class)
public class NkPipelineBuilderAdapter implements IVulkanAdapter
{
	public static final long INDEXED_BUFFER_SIZE = (long) Math.pow(2, 19);
	public static final long INDEX_BUFFER_SIZE = (long) Math.pow(2, 16);
	public static final long VERTEX_BUFFER_SIZE = INDEXED_BUFFER_SIZE - INDEX_BUFFER_SIZE;
	public static final long INDEX_OFFSET = INDEXED_BUFFER_SIZE - INDEX_BUFFER_SIZE;

	private final GraphicsPipeline pipeline;
	private final NuklearPipelineBuilder builder;

	private ResourceBuilder resourceBuilder;

	public NkPipelineBuilderAdapter(NuklearPipelineBuilder builder)
	{
		this.builder = builder;
		pipeline = (GraphicsPipeline) builder.eContainer();

		final var rasterizer = GraphicpipelineFactory.eINSTANCE.createRasterizer();
		rasterizer.setCullMode(ECullMode.NONE);
		pipeline.setRasterizer(rasterizer);
		pipeline.setInputAssembly(GraphicpipelineFactory.eINSTANCE.createInputAssembly());
		pipeline.setViewportState(ViewportStateFactory.create());
		pipeline.setColorBlend(ColorBlendFactory.create());
		pipeline.setDynamicState(DynamicStateFactory.create());
		pipeline.setTaskPkg(ProcessFactory.eINSTANCE.createTaskPkg());
	}

	@Autorun
	public void build()
	{
		resourceBuilder = ResourceBuilder.setup(pipeline, builder.getFont());
		PushContantsBuilder.setup(pipeline);
		ShaderBuilder.setup(pipeline);
		VertexDescriptorBuilder.setup(pipeline);
		setupBindDescriptorTask();
		setupDrawTasks();
	}

	private void setupBindDescriptorTask()
	{
		final var bindDescriptorSet = ProcessFactory.eINSTANCE.createBindDescriptorSets();
		pipeline.getTaskPkg().getTasks().add(bindDescriptorSet);
	}

	private void setupDrawTasks()
	{
		final var pushBuffer = ResourceFactory.eINSTANCE.createPushBuffer();
		pushBuffer.setSize(INDEXED_BUFFER_SIZE);

		final var drawTask = ProcessFactory.eINSTANCE.createCompositeTask();
		final var layoutTask = NuklearFactory.eINSTANCE.createNuklearLayoutTask();
		layoutTask.setContext(resourceBuilder.context);
		layoutTask.setVertexBuffer(resourceBuilder.vertexBuffer);
		layoutTask.setDrawTask(drawTask);
		layoutTask.setPushBuffer(pushBuffer);

		pipeline.getResourcePkg().getResources().add(pushBuffer);

		pipeline.getTaskPkg().getTasks().add(layoutTask);
		pipeline.getTaskPkg().getTasks().add(drawTask);
	}

	public static void dumpVertex(long memoryAddress, long size)
	{
		final int elemSize = (int) (size / 4);
		final ByteBuffer buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) size);
		for (int i = 0; i < elemSize - 5; i += 5)
		{
			final float x = buffer.getFloat();
			final float y = buffer.getFloat();
			final float u = buffer.getFloat();
			final float v = buffer.getFloat();
			final int color = buffer.getInt();
			final int r = color & 255;
			final int g = (color >> 8) & 255;
			final int b = (color >> 16) & 255;
			final int a = (color >> 24) & 255;
			final int index = i / 5;

			if (x != 0 || y != 0) System.out.print(
					String.format("%d| p:{%.0f, %.0f}, uv:{%.2f, %.2f}, rgb:{%d, %d, %d, %d}\n",
							index, x, y, u, v, r, g, b, a));
		}
	}

	public static void dumpIndex(long memoryAddress, long size)
	{
		final int elemSize = (int) (size / 2);
		final ByteBuffer buffer = MemoryUtil.memByteBuffer(memoryAddress, (int) size);
		for (int i = 0; i < elemSize - 3; i += 3)
		{
			final int i1 = buffer.getShort();
			final int i2 = buffer.getShort();
			final int i3 = buffer.getShort();

			if (i1 != 0 || i2 != 0 || i3 != 0)
				System.out.print(String.format("i:{%d, %d, %d}\n", i1, i2, i3));
		}
	}
}
