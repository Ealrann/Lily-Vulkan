/**
 */
package org.sheepy.lily.vulkan.model.binding;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rotate Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration#isForceRecord <em>Force Record</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getRotateConfiguration()
 * @model
 * @generated
 */
public interface RotateConfiguration extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' reference list.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getRotateConfiguration_Configurations()
	 * @model required="true"
	 * @generated
	 */
	EList<BindingConfiguration> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Force Record</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force Record</em>' attribute.
	 * @see #setForceRecord(boolean)
	 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage#getRotateConfiguration_ForceRecord()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isForceRecord();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration#isForceRecord <em>Force Record</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force Record</em>' attribute.
	 * @see #isForceRecord()
	 * @generated
	 */
	void setForceRecord(boolean value);

} // RotateConfiguration
