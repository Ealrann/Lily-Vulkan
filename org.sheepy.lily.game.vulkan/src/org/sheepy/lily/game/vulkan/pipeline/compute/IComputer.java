package org.sheepy.lily.game.vulkan.pipeline.compute;

import org.sheepy.lily.game.vulkan.descriptor.IDescriptorSetConfiguration;
import org.sheepy.lily.game.vulkan.shader.Shader;

public interface IComputer extends IDescriptorSetConfiguration
{
	void load();
	
	Shader getShader();

	int getDataWidth();

	int getDataHeight();

	int getDataDepth();

	void free();

}
