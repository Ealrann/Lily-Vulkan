/**
 */
package org.sheepy.vulkan.model.barrier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.enumeration.EAccess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.Barrier#getSrcAccessMask <em>Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.Barrier#getDstAccessMask <em>Dst Access Mask</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getBarrier()
 * @model abstract="true"
 * @generated
 */
public interface Barrier extends EObject
{
	/**
	 * Returns the value of the '<em><b>Src Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getBarrier_SrcAccessMask()
	 * @model
	 * @generated
	 */
	EList<EAccess> getSrcAccessMask();

	/**
	 * Returns the value of the '<em><b>Dst Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getBarrier_DstAccessMask()
	 * @model
	 * @generated
	 */
	EList<EAccess> getDstAccessMask();

} // Barrier
