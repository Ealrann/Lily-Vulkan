package org.sheepy.lily.vulkan.core.debug;

import org.lwjgl.vulkan.VkDebugReportCallbackEXT;
import org.sheepy.lily.vulkan.api.debug.IVulkanDebugService;

import java.math.BigInteger;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public final class DebugReportCallbackImpl extends VkDebugReportCallbackEXT
{
	public static final BigInteger NEG = BigInteger.ONE.shiftLeft(127);
	private static final Pattern PATTERN = Pattern.compile("0x[0-9a-fA-F]+");
	private static final IVulkanDebugService debugService = IVulkanDebugService.INSTANCE;

	@Override
	public int invoke(int flags,
					  int objectType,
					  long object,
					  long location,
					  int messageCode,
					  long pLayerPrefix,
					  long pMessage,
					  long pUserData)
	{
		final var message = VkDebugReportCallbackEXT.getString(pMessage);
		final var matcher = PATTERN.matcher(message);
		final var displayMessage = matcher.replaceAll(DebugReportCallbackImpl::buildFriendlyName);

		System.err.println("ERROR OCCURED: " + displayMessage);
		return 0;
	}

	private static String buildFriendlyName(MatchResult result)
	{
		final var hexString = result.group();

		BigInteger b = new BigInteger(hexString.substring(2), 16);
		if(b.compareTo(NEG) >= 0) {
			b = NEG.subtract(b);
		}

		final var ptr = b.longValue();
		final var name = debugService.get(ptr);
		return name != null ? name + " (" + hexString + ")" : hexString;
	}
}
