/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear;

import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Viewer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.TableViewer#getVariableResolver <em>Variable Resolver</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getTableViewer()
 * @model
 * @generated
 */
public interface TableViewer extends Panel
{
	/**
	 * Returns the value of the '<em><b>Variable Resolver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #setVariableResolver(DirectVariableResolver)
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage#getTableViewer_VariableResolver()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DirectVariableResolver getVariableResolver();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.nuklear.TableViewer#getVariableResolver <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Resolver</em>' containment reference.
	 * @see #getVariableResolver()
	 * @generated
	 */
	void setVariableResolver(DirectVariableResolver value);

} // TableViewer
