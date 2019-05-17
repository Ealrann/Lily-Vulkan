package org.sheepy.lily.vulkan.nuklear.builder.internal;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.IndexedVertexDescriptor;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EIndexType;

public class VertexDescriptorBuilder
{
	public static final int SIZE_OF_VERTEX = 5 * 4;
	public static final int POSITION_OFFSET = 0;
	public static final int TEX_COORD_OFFSET = 2 * 4;
	public static final int COLOR_OFFSET = 4 * 4;

	public static final VertexDescriptorBuilder setup(GraphicsPipeline pipeline)
	{
		pipeline.setVertexDescriptor(createVertexDescriptor());
		return new VertexDescriptorBuilder();
	}

	private VertexDescriptorBuilder()
	{}

	private static IndexedVertexDescriptor createVertexDescriptor()
	{
		final var locationAttribute = GraphicFactory.eINSTANCE.createAttributeDescription();
		locationAttribute.setFormat(EFormat.R32G32_SFLOAT);
		locationAttribute.setOffset(POSITION_OFFSET);

		final var colorAttribute = GraphicFactory.eINSTANCE.createAttributeDescription();
		colorAttribute.setFormat(EFormat.R32G32_SFLOAT);
		colorAttribute.setOffset(TEX_COORD_OFFSET);

		final var textureAttribute = GraphicFactory.eINSTANCE.createAttributeDescription();
		textureAttribute.setFormat(EFormat.R8G8B8A8_UNORM);
		textureAttribute.setOffset(COLOR_OFFSET);

		final var vertexDescriptor = GraphicFactory.eINSTANCE.createIndexedVertexDescriptor();
		vertexDescriptor.setIndexType(EIndexType.UINT16);
		vertexDescriptor.setStrideLength(SIZE_OF_VERTEX);
		vertexDescriptor.getAttributes().add(locationAttribute);
		vertexDescriptor.getAttributes().add(colorAttribute);
		vertexDescriptor.getAttributes().add(textureAttribute);

		return vertexDescriptor;
	}
}
