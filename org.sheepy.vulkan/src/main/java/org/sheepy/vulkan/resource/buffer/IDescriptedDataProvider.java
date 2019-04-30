package org.sheepy.vulkan.resource.buffer;

import java.util.List;

import org.sheepy.vulkan.model.enumeration.EShaderStage;

public interface IDescriptedDataProvider extends IBufferDataProvider
{
	List<EShaderStage> getStages();
}
