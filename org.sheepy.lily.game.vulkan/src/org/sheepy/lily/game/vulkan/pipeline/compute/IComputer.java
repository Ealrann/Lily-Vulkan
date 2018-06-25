package org.sheepy.lily.game.vulkan.pipeline.compute;

import java.util.List;

import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.shader.Shader;

public interface IComputer
{
	Shader getShader();
	List<IDescriptor> getDescriptors();

	int getDataWidth();

	int getDataHeight();

	int getDataDepth();

	void free();

}
