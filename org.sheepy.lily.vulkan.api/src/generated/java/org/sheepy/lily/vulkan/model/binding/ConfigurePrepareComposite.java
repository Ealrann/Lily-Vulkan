/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.resource.CompositePartReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configure Prepare Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getReferences <em>References</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getTargetInstance <em>Target Instance</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite()
 * @model
 * @generated
 */
public interface ConfigurePrepareComposite extends IConfigurationTask
{
	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.resource.CompositePartReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite_References()
	 * @model required="true"
	 * @generated
	 */
	EList<CompositePartReference> getReferences();

	/**
	 * Returns the value of the '<em><b>Target Instance</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.binding.EInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Instance</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see #setTargetInstance(EInstance)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getConfigurePrepareComposite_TargetInstance()
	 * @model required="true"
	 * @generated
	 */
	EInstance getTargetInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite#getTargetInstance <em>Target Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Instance</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.binding.EInstance
	 * @see #getTargetInstance()
	 * @generated
	 */
	void setTargetInstance(EInstance value);

} // ConfigurePrepareComposite
