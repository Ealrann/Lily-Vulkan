/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.ui.Font;

import org.sheepy.vulkan.model.enumeration.EInstanceCount;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontImage#getFonts <em>Fonts</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.FontImage#getInstanceCount <em>Instance Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFontImage()
 * @model
 * @generated
 */
public interface FontImage extends Image
{
	/**
	 * Returns the value of the '<em><b>Fonts</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.core.model.ui.Font}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fonts</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFontImage_Fonts()
	 * @model
	 * @generated
	 */
	EList<Font> getFonts();

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EInstanceCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #setInstanceCount(EInstanceCount)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getFontImage_InstanceCount()
	 * @model required="true"
	 * @generated
	 */
	EInstanceCount getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.FontImage#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(EInstanceCount value);

} // FontImage
