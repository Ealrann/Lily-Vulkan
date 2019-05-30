package org.sheepy.lily.vulkan.nuklear.builder.internal;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearContext;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearFactory;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;
import org.sheepy.lily.vulkan.model.resource.Font;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.lily.vulkan.model.resource.SampledImage;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NullTextureAdapter;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public class ResourceBuilder
{
	public final SampledImage nullTexture;
	public final Font font;
	public final Buffer vertexBuffer;
	public final NuklearContext context;

	public static final ResourceBuilder setup(GraphicsPipeline pipeline, Font fontPattern)
	{
		final var nullTexture = createNullTexture();
		final var font = EcoreUtil.copy(fontPattern);
		final var context = NuklearFactory.eINSTANCE.createNuklearContext();
		font.setName(NuklearFontAdapter.MODEL_OBJECT_NAME);
		context.setFont(font);
		context.setNullTexture(nullTexture);

		final var indexedVertexBuffer = ResourceFactory.eINSTANCE.createBuffer();
		indexedVertexBuffer.setSize((long) Math.pow(2, 19));
		indexedVertexBuffer.getUsages().add(EBufferUsage.VERTEX_BUFFER_BIT);
		indexedVertexBuffer.getUsages().add(EBufferUsage.INDEX_BUFFER_BIT);
		indexedVertexBuffer.getUsages().add(EBufferUsage.TRANSFER_DST_BIT);

		final var resourcePkg = VulkanFactory.eINSTANCE.createResourcePkg();
		resourcePkg.getResources().add(nullTexture);
		resourcePkg.getResources().add(font);
		resourcePkg.getResources().add(indexedVertexBuffer);
		resourcePkg.getResources().add(context);

		pipeline.setResourcePkg(resourcePkg);

		final DescriptorSet descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
		descriptorSet.getDescriptors().add(nullTexture);
		descriptorSet.getDescriptors().add(font);

		final DescriptorSetPkg descriptorSetPkg = ResourceFactory.eINSTANCE.createDescriptorSetPkg();
		pipeline.setDescriptorSetPkg(descriptorSetPkg);
		descriptorSetPkg.getDescriptorSets().add(descriptorSet);

		return new ResourceBuilder(nullTexture, font, indexedVertexBuffer, context);
	}

	private ResourceBuilder(SampledImage nullTexture,
							Font font,
							Buffer vertexBuffer,
							NuklearContext context)
	{
		this.nullTexture = nullTexture;
		this.font = font;
		this.vertexBuffer = vertexBuffer;
		this.context = context;
	}

	private static SampledImage createNullTexture()
	{
		final var nullTexture = ResourceFactory.eINSTANCE.createSampledImage();
		nullTexture.setDescriptorType(EDescriptorType.SAMPLED_IMAGE);
		nullTexture.setName(NullTextureAdapter.MODEL_OBJECT_NAME);
		nullTexture.getShaderStages().add(EShaderStage.FRAGMENT_BIT);
		nullTexture.setSampler(ResourceFactory.eINSTANCE.createSampler());

		return nullTexture;
	}
}
