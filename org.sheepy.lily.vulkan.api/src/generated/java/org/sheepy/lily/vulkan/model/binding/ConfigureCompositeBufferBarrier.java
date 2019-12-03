/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configure Composite Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getBarrier <em>Barrier</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getTargetInstance <em>Target Instance</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier()
 * @model
 * @generated
 */
public interface ConfigureCompositeBufferBarrier extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>Barrier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Barrier</em>' reference.
	 * @see #setBarrier(CompositeBufferBarrier)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier_Barrier()
	 * @model required="true"
	 * @generated
	 */
	CompositeBufferBarrier getBarrier();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getBarrier <em>Barrier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Barrier</em>' reference.
	 * @see #getBarrier()
	 * @generated
	 */
	void setBarrier(CompositeBufferBarrier value);

	/**
	 * Returns the value of the '<em><b>Target Instance</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.binding.EInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Instance</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see #setTargetInstance(EInstance)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigureCompositeBufferBarrier_TargetInstance()
	 * @model required="true"
	 * @generated
	 */
	EInstance getTargetInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier#getTargetInstance <em>Target Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Instance</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see #getTargetInstance()
	 * @generated
	 */
	void setTargetInstance(EInstance value);

} // ConfigureCompositeBufferBarrier
