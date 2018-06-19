package org.sheepy.lily.game.vulkan.descriptor;

public interface IDescriptorSetConfiguration<T extends IDescriptor> extends Iterable<T>
{
	int size();
}
