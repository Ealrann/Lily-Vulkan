/**
 */
package org.sheepy.vulkan.model.barrier;

import org.sheepy.vulkan.model.enumeration.EImageLayout;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.barrier.AbstractImageBarrier#getSrcLayout <em>Src Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.barrier.AbstractImageBarrier#getDstLayout <em>Dst Layout</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getAbstractImageBarrier()
 * @model abstract="true"
 * @generated
 */
public interface AbstractImageBarrier extends Barrier
{
	/**
	 * Returns the value of the '<em><b>Src Layout</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EImageLayout}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setSrcLayout(EImageLayout)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getAbstractImageBarrier_SrcLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getSrcLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.AbstractImageBarrier#getSrcLayout <em>Src Layout</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #setDstLayout(EImageLayout)
	 * @see org.sheepy.vulkan.model.barrier.BarrierPackage#getAbstractImageBarrier_DstLayout()
	 * @model unique="false"
	 * @generated
	 */
	EImageLayout getDstLayout();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.barrier.AbstractImageBarrier#getDstLayout <em>Dst Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst Layout</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EImageLayout
	 * @see #getDstLayout()
	 * @generated
	 */
	void setDstLayout(EImageLayout value);

} // AbstractImageBarrier
