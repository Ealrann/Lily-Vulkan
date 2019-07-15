/**
 */
package org.sheepy.lily.vulkan.model.resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.ModuleResource#getModule <em>Module</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getModuleResource()
 * @model
 * @generated
 */
public interface ModuleResource extends AbstractModuleResource
{
	/**
	 * Returns the value of the '<em><b>Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' attribute.
	 * @see #setModule(Module)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getModuleResource_Module()
	 * @model unique="false" dataType="org.sheepy.lily.vulkan.model.resource.JavaModule"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.ModuleResource#getModule <em>Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' attribute.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

} // ModuleResource
