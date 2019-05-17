package org.sheepy.lily.vulkan.demo.mesh;

import java.nio.ByteBuffer;

import org.sheepy.vulkan.model.enumeration.EFrontFace;

public class MeshConfiguration
{
	
	public String texturePath = null;
	public String vertexShaderPath = "triangle.vert.spv";
	public String fragmentShaderPath = "triangle.frag.spv";
	public Module module = MeshConfiguration.class.getModule();
	

	public boolean useCamera = false;
	public boolean depth = false;

	public EFrontFace rasterizerFrontFace = EFrontFace.CLOCKWISE;

	public int width = 800;
	public int height = 600;
	public boolean mipmap = false;
	public boolean useTexture = false;
	

	@Deprecated
	public String meshProviderName;
	public long indexOffset;
	public int indexCount;
	public ByteBuffer vertexData;
	
	
	public MeshConfiguration(AbstractMeshBuilder meshBuilder)
	{
		vertexData = meshBuilder.getData();
		indexCount = meshBuilder.getIndexCount();
		indexOffset = meshBuilder.getIndexOffset();
	}
}
