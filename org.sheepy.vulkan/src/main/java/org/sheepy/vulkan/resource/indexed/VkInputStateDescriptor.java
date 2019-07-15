package org.sheepy.vulkan.resource.indexed;

import static org.lwjgl.vulkan.VK10.VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO;

import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkPipelineVertexInputStateCreateInfo;
import org.lwjgl.vulkan.VkVertexInputAttributeDescription;
import org.lwjgl.vulkan.VkVertexInputBindingDescription;
import org.sheepy.vulkan.model.enumeration.EInputRate;

public class VkInputStateDescriptor
{
	private final List<VkVertexBinding> bindings;
	private final int vertexSize;
	private final int attributeCount;

	public VkInputStateDescriptor(List<VkVertexBinding> bindings)
	{
		this.bindings = List.copyOf(bindings);
		vertexSize = computeVertexSize();
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

	private int computeVertexSize()
	{
		int size = 0;
		for (final var vkVertexBinding : bindings)
		{
			if (vkVertexBinding.inputRate == EInputRate.VERTEX)
			{
				size += vkVertexBinding.strideLength;
			}
		}
		return size;
	}

	public VkPipelineVertexInputStateCreateInfo allocCreateInfo(MemoryStack stack)
	{
		final var vertexInputInfo = VkPipelineVertexInputStateCreateInfo.callocStack(stack);
		vertexInputInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);

		final var allocBindingDescription = allocBindingDescription(stack);
		final var getgetAttributeDescriptions = allocAttributeDescriptions(stack);

		vertexInputInfo.pVertexBindingDescriptions(allocBindingDescription);
		vertexInputInfo.pVertexAttributeDescriptions(getgetAttributeDescriptions);

		return vertexInputInfo;
	}

	public VkVertexInputBindingDescription.Buffer allocBindingDescription(MemoryStack stack)
	{
		final var bindingDescriptions = VkVertexInputBindingDescription.mallocStack(bindings.size(),
				stack);

		for (int i = 0; i < bindings.size(); i++)
		{
			final VkVertexBinding binding = bindings.get(i);
			final var bindingDescription = bindingDescriptions.get();
			bindingDescription.binding(i);
			bindingDescription.stride(binding.strideLength);
			bindingDescription.inputRate(binding.inputRate.getValue());
		}

		return bindingDescriptions.flip();
	}

	public VkVertexInputAttributeDescription.Buffer allocAttributeDescriptions(MemoryStack stack)
	{
		final var attributeDescriptions = VkVertexInputAttributeDescription
				.callocStack(attributeCount, stack);

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
				attributeDescriptionPosition.binding(bindingIndex);
				attributeDescriptionPosition.location(location++);
				attributeDescriptionPosition.format(format);
				attributeDescriptionPosition.offset(offset);
			}
		}

		return attributeDescriptions.flip();
	}

	public final int sizeOfVertex()
	{
		return vertexSize;
	}

	public static final class VkVertexBinding
	{
		public final EInputRate inputRate;
		public int strideLength;
		public final List<VkAttributeDescription> attributes;

		public VkVertexBinding(	EInputRate inputRate,
								int strideLength,
								List<VkAttributeDescription> attributes)
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
