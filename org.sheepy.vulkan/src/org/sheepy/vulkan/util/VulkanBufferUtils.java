package org.sheepy.vulkan.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;

public class VulkanBufferUtils
{
	/**
	 * Reads the specified resource and returns the raw data as a ByteBuffer.
	 *
	 * @param resource
	 *            the resource to read
	 * @param bufferSize
	 *            the initial buffer size
	 *
	 * @return the resource data
	 *
	 * @throws IOException
	 *             if an IO error occurs
	 */
	public static ByteBuffer ioResourceToByteBuffer(String resource, int initialBufferSize)
			throws IOException
	{
		System.out.println(resource);
		ByteBuffer buffer = null;
		InputStream fis = null;

		try
		{
			fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
			byte[] byteArray = fis.readAllBytes();

			buffer = ByteBuffer.allocateDirect(byteArray.length);

			buffer.put(byteArray);
			buffer.flip();

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (fis != null) fis.close();
		}
		return buffer;
	}

	public static final long[] toArray(LongBuffer buffer)
	{
		long[] res = new long[buffer.capacity()];

		for (int i = 0; i < buffer.capacity(); i++)
		{
			res[i] = buffer.get(i);
		}

		return res;
	}

	public static final List<Long> toList(LongBuffer buffer)
	{
		List<Long> res = new ArrayList<>();

		for (int i = 0; i < buffer.capacity(); i++)
		{
			res.add(buffer.get(i));
		}

		return res;
	}
}
