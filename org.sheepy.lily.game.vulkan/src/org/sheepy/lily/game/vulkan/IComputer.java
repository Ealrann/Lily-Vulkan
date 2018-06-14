package org.sheepy.lily.game.vulkan;

import org.sheepy.lily.game.vulkan.descriptor.IDescriptor;
import org.sheepy.lily.game.vulkan.shader.Shader;

public interface IComputer extends IDescriptor
{
	Shader getShader();
}
