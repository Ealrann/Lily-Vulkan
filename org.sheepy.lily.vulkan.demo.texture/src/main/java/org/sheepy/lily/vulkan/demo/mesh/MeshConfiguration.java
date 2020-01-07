package org.sheepy.lily.vulkan.demo.mesh;

import java.nio.ByteBuffer;

import org.joml.Vector2ic;
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

	public int indexCount;
	public ByteBuffer vertexData;
	public ByteBuffer indexData;

	public MeshConfiguration(AbstractMeshBuilder meshBuilder, Vector2ic size)
	{
		this.width = size.x();
		this.height = size.y();

		vertexData = meshBuilder.getVertexData();
		indexData = meshBuilder.getIndexData();
		indexCount = meshBuilder.getIndexCount();
	}
}
