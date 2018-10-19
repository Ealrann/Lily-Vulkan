/**
 */
package org.sheepy.vulkan.model;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.ImageTransition#getSrcLayout <em>Src Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImageTransition#getDstLayout <em>Dst Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImageTransition#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.ImageTransition#getDstAccess <em>Dst Access</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.VulkanPackage#getImageTransition()
 * @model
 * @generated
 */
public interface ImageTransition extends EObject
{
	/**
	 * Returns the value of the '<em><b>Src Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setSrcLayout(EImageLayout)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImageTransition_SrcLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getSrcLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImageTransition#getSrcLayout <em>Src Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getSrcLayout()
	 * @generated
	 */
	void setSrcLayout(EImageLayout value);

	/**
	 * Returns the value of the '<em><b>Dst Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Layout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setDstLayout(EImageLayout)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImageTransition_DstLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getDstLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImageTransition#getDstLayout <em>Dst Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getDstLayout()
	 * @generated
	 */
	void setDstLayout(EImageLayout value);

	/**
	 * Returns the value of the '<em><b>Src Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access</em>' attribute.
	 * @see #setSrcAccess(int)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImageTransition_SrcAccess()
	 * @model unique="false"
	 * @generated
	 */
	int getSrcAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImageTransition#getSrcAccess <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Access</em>' attribute.
	 * @see #getSrcAccess()
	 * @generated
	 */
	void setSrcAccess(int value);

	/**
	 * Returns the value of the '<em><b>Dst Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Access</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access</em>' attribute.
	 * @see #setDstAccess(int)
	 * @see org.sheepy.vulkan.model.VulkanPackage#getImageTransition_DstAccess()
	 * @model unique="false"
	 * @generated
	 */
	int getDstAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.ImageTransition#getDstAccess <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Access</em>' attribute.
	 * @see #getDstAccess()
	 * @generated
	 */
	void setDstAccess(int value);

} // ImageTransition
