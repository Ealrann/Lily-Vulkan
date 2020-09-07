package org.sheepy.lily.vulkan.process.graphic.pipeline;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.vulkan.model.enumeration.EInputRate;

import java.util.List;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO;

public final class VkInputStateDescriptor
{
	private final List<VkVertexBinding> bindings;
	private final int attributeCount;

	public VkInputStateDescriptor(List<VkVertexBinding> bindings)
	{
		this.bindings = List.copyOf(bindings);
		attributeCount = countAttributes();
	}

	private int countAttributes()
	{
		int count = 0;
		for (final var binding : bindings)
		{
			count += binding.attributes.size();
		}
		return count;
	}

	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		final var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.mallocStack(stack);
		final var bindingDescription = allocBindingDescription(stack);
		final var attributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.set(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO,
							0,
							0,
							bindingDescription,
							attributeDescriptions);

		return vertexInputInfo;
	}

	public VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescriptions = VkVertexInputBindingDescription.mallocStack(bindings.size(), stack);

		for (int i = 0; i < bindings.size(); i++)
		{
			final VkVertexBinding binding = bindings.get(i);
			bindingDescriptions.get().set(i, binding.strideLength, binding.inputRate.getValue());
		}

		return bindingDescriptions.flip();
	}

	public VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final var attributeDescriptions = VkVertexInputAttributeDescription.mallocStack(attributeCount, stack);

		int location = 0;
		for (int bindingIndex = 0; bindingIndex < bindings.size(); bindingIndex++)
		{
			final var binding = bindings.get(bindingIndex);
			final var attributes = binding.attributes;
			for (int i = 0; i < attributes.size(); i++)
			{
				final var attribute = attributes.get(i);
				final int offset = attribute.offset;
				final int format = attribute.format;

				final var attributeDescriptionPosition = attributeDescriptions.get();
				attributeDescriptionPosition.set(location++, bindingIndex, format, offset);
			}
		}

		return attributeDescriptions.flip();
	}

	public static final class VkVertexBinding
	{
		public final EInputRate inputRate;
		public int strideLength;
		public final List<VkAttributeDescription> attributes;

		public VkVertexBinding(EInputRate inputRate, int strideLength, List<VkAttributeDescription> attributes)
		{
			this.inputRate = inputRate;
			this.strideLength = strideLength;
			this.attributes = List.copyOf(attributes);
		}
	}

	public static final class VkAttributeDescription
	{
		public final int format;
		public final int offset;

		public VkAttributeDescription(int format, int offset)
		{
			this.format = format;
			this.offset = offset;
		}
	}
}
