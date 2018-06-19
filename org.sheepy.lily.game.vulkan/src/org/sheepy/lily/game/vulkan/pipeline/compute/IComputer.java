package org.sheepy.lily.game.vulkan.pipeline.compute;

import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.shader.Shader;

public interface IComputer extends IDescriptor
{
	Shader getShader();

	int getDataWidth();
	int getDataHeight();
	int getDataDepth();
	
	void free();
}
