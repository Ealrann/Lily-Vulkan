package org.sheepy.vulkan.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ModuleResource
{
	private int initialBufferSize = 1024;
	
	public final Module module;
	public final String path;

	public ModuleResource(Module module, String path)
	{
		this.module = module;
		this.path = path;
	}

	public ByteBuffer ioResourceToByteBuffer()
	{
		ByteBuffer buffer = null;
		InputStream fis = null;

		try
		{
			fis = module.getResourceAsStream(path);
			byte[] byteArray = fis.readAllBytes();

			buffer = ByteBuffer.allocateDirect(byteArray.length);

			buffer.put(byteArray);
			buffer.flip();

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (fis != null) try
			{
				fis.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return buffer;
	}

	public int getInitialBufferSize()
	{
		return initialBufferSize;
	}

	public void setInitialBufferSize(int initialBufferSize)
	{
		this.initialBufferSize = initialBufferSize;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ModuleResource other = (ModuleResource) obj;
		if (module == null)
		{
			if (other.module != null) return false;
		}
		else if (!module.equals(other.module)) return false;
		if (path == null)
		{
			if (other.path != null) return false;
		}
		else if (!path.equals(other.path)) return false;
		return true;
	}
}
