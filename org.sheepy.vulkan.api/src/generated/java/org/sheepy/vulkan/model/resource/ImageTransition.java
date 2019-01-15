/**
 */
package org.sheepy.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EAccess;
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
 *   <li>{@link org.sheepy.vulkan.model.resource.ImageTransition#getSrcLayout <em>Src Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.ImageTransition#getDstLayout <em>Dst Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.ImageTransition#getSrcAccessMask <em>Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.ImageTransition#getDstAccessMask <em>Dst Access Mask</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getImageTransition()
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
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getImageTransition_SrcLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getSrcLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.ImageTransition#getSrcLayout <em>Src Layout</em>}' attribute.
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
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getImageTransition_DstLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getDstLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.ImageTransition#getDstLayout <em>Dst Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getDstLayout()
	 * @generated
	 */
	void setDstLayout(EImageLayout value);

	/**
	 * Returns the value of the '<em><b>Src Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Access Mask</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getImageTransition_SrcAccessMask()
	 * @model unique="false"
	 * @generated
	 */
	EList<EAccess> getSrcAccessMask();

	/**
	 * Returns the value of the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Access Mask</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getImageTransition_DstAccessMask()
	 * @model unique="false"
	 * @generated
	 */
	EList<EAccess> getDstAccessMask();

} // ImageTransition
