package org.sheepy.lily.game.vulkan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;

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
		ByteBuffer buffer;
		URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
		File file = new File(url.getFile());
		if (file.isFile())
		{
			FileInputStream fis = new FileInputStream(file);
			FileChannel fc = fis.getChannel();
			buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			fc.close();
			fis.close();
		}
		else
		{
			buffer = BufferUtils.createByteBuffer(initialBufferSize);
			InputStream source = url.openStream();
			if (source == null)
				throw new FileNotFoundException(resource);
			try
			{
				ReadableByteChannel rbc = Channels.newChannel(source);
				try
				{
					while (true)
					{
						int bytes = rbc.read(buffer);
						if (bytes == -1)
							break;
						if (buffer.remaining() == 0)
							buffer = resizeBuffer(buffer, buffer.capacity() * 2);
					}
					buffer.flip();
				} finally
				{
					rbc.close();
				}
			} finally
			{
				source.close();
			}
		}
		return buffer;
	}

	private static ByteBuffer resizeBuffer(ByteBuffer buffer, int newCapacity)
	{
		ByteBuffer newBuffer = BufferUtils.createByteBuffer(newCapacity);
		buffer.flip();
		newBuffer.put(buffer);
		newBuffer.flip();
		return newBuffer;
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
