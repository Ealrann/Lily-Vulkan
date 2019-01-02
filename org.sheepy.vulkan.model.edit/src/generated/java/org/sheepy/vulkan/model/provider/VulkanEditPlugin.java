/**
 */
package org.sheepy.vulkan.model.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;
import org.sheepy.common.model.action.provider.ActionEditPlugin;
import org.sheepy.common.model.application.provider.ApplicationEditPlugin;
import org.sheepy.common.model.inference.provider.InferenceEditPlugin;
import org.sheepy.common.model.root.provider.RootEditPlugin;
import org.sheepy.common.model.types.provider.TypesEditPlugin;
import org.sheepy.vulkan.model.enumeration.provider.EnumerationEditPlugin;

/**
 * This is the central singleton for the Vulkan edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class VulkanEditPlugin extends EMFPlugin
{
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final VulkanEditPlugin INSTANCE = new VulkanEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanEditPlugin()
	{
		super
		  (new ResourceLocator [] 
		   {
		     ApplicationEditPlugin.INSTANCE,
		     RootEditPlugin.INSTANCE,
		     InferenceEditPlugin.INSTANCE,
		     TypesEditPlugin.INSTANCE,
		     EnumerationEditPlugin.INSTANCE,
		     ActionEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin()
	{
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin
	{
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation()
		{
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
