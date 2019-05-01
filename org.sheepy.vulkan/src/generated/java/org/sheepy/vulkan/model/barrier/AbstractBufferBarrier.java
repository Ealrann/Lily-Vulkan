/**
 */
package org.sheepy.vulkan.model.barrier;

import org.sheepy.vulkan.model.enumeration.EAccess;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getSrcAccess <em>Src Access</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getDstAccess <em>Dst Access</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getAbstractBufferBarrier()
 * @model abstract="true"
 * @generated
 */
public interface AbstractBufferBarrier extends Barrier
{
	/**
	 * Returns the value of the '<em><b>Src Access</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Access</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see #setSrcAccess(EAccess)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getAbstractBufferBarrier_SrcAccess()
	 * @model unique="false"
	 * @generated
	 */
	EAccess getSrcAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getSrcAccess <em>Src Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Access</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see #getSrcAccess()
	 * @generated
	 */
	void setSrcAccess(EAccess value);

	/**
	 * Returns the value of the '<em><b>Dst Access</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Access</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see #setDstAccess(EAccess)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getAbstractBufferBarrier_DstAccess()
	 * @model unique="false"
	 * @generated
	 */
	EAccess getDstAccess();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.AbstractBufferBarrier#getDstAccess <em>Dst Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Access</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see #getDstAccess()
	 * @generated
	 */
	void setDstAccess(EAccess value);

} // AbstractBufferBarrier
