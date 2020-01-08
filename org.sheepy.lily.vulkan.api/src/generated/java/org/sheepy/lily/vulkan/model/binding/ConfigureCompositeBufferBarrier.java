/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.resource.BufferBarrier;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configure Composite Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getBarriers <em>Barriers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getPartIndex <em>Part Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getCompositeBuffer <em>Composite Buffer</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier()
 * @model
 * @generated
 */
public interface ConfigureCompositeBufferBarrier extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>Barriers</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.BufferBarrier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Barriers</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier_Barriers()
	 * @model required="true"
	 * @generated
	 */
	EList<BufferBarrier> getBarriers();

	/**
	 * Returns the value of the '<em><b>Part Index</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.binding.EContextIndex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Index</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @see #setPartIndex(EContextIndex)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier_PartIndex()
	 * @model required="true"
	 * @generated
	 */
	EContextIndex getPartIndex();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getPartIndex <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Index</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EContextIndex
	 * @see #getPartIndex()
	 * @generated
	 */
	void setPartIndex(EContextIndex value);

	/**
	 * Returns the value of the '<em><b>Composite Buffer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Buffer</em>' reference.
	 * @see #setCompositeBuffer(CompositeBuffer)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier_CompositeBuffer()
	 * @model required="true"
	 * @generated
	 */
	CompositeBuffer getCompositeBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getCompositeBuffer <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Buffer</em>' reference.
	 * @see #getCompositeBuffer()
	 * @generated
	 */
	void setCompositeBuffer(CompositeBuffer value);

} // ConfigureCompositeBufferBarrier
