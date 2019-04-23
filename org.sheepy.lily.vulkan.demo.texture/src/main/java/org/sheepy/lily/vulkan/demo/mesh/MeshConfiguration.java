package org.sheepy.lily.vulkan.demo.mesh;

import org.sheepy.vulkan.model.enumeration.EFrontFace;

public class MeshConfiguration
{
	public String texturePath = null;
	public String vertexShaderPath = "triangle.vert.spv";
	public String fragmentShaderPath = "triangle.frag.spv";
	public Module module = MeshConfiguration.class.getModule();

	public boolean buildUniformBuffer = false;
	public boolean depth = false;

	public EFrontFace rasterizerFrontFace = EFrontFace.CLOCKWISE;

	public int width = 800;
	public int height = 600;
	public boolean mipmap = false;
}
